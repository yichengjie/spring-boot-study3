1. Executor-执行器
    ```java
    public class DefaultSqlSessionFactory implements SqlSessionFactory {
        private SqlSession openSessionFromDataSource(ExecutorType execType, TransactionIsolationLevel level, boolean autoCommit) {
             Transaction tx = null;
             try {
                 final Environment environment = configuration.getEnvironment();
                 final TransactionFactory transactionFactory = getTransactionFactoryFromEnvironment(environment);
                 tx = transactionFactory.newTransaction(environment.getDataSource(), level, autoCommit);
                 //★★★ 1. 创建Executor 代理类
                 final Executor executor = configuration.newExecutor(tx, execType);
                 return new DefaultSqlSession(configuration, executor, autoCommit);
             } catch (Exception e) {
                 closeTransaction(tx); // may have fetched a connection so lets call close()
                 throw ExceptionFactory.wrapException("Error opening session.  Cause: " + e, e);
             } finally {
                 ErrorContext.instance().reset();
             }
        }   
    }
    ``` 
2. StatementHandler-SQL语句处理器
    ```java
    public class SimpleExecutor extends BaseExecutor {
        @Override
        public <E> List<E> doQuery(MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) throws SQLException {
            Statement stmt = null;
            try {
                Configuration configuration = ms.getConfiguration();
                //★★★ 2. 创建StatementHandler代理类
                StatementHandler handler = configuration.newStatementHandler(wrapper, ms, parameter, rowBounds, resultHandler, boundSql);
                stmt = prepareStatement(handler, ms.getStatementLog());
                return handler.query(stmt, resultHandler);
            } finally {
                closeStatement(stmt);
            }
        }
    }
    ```
3. ParameterHandler-参数处理器，与ResultSetHandler-结果集处理器
    ```java
    public abstract class BaseStatementHandler implements StatementHandler {
        // 创建StatementHandler的同时创建ParameterHandler与ResultSetHandler
        protected BaseStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameterObject, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) {
            this.configuration = mappedStatement.getConfiguration();
            this.executor = executor;
            this.mappedStatement = mappedStatement;
            this.rowBounds = rowBounds;
            this.typeHandlerRegistry = configuration.getTypeHandlerRegistry();
            this.objectFactory = configuration.getObjectFactory();
            if (boundSql == null) { // issue #435, get the key before calculating the statement
              generateKeys(parameterObject);
              boundSql = mappedStatement.getBoundSql(parameterObject);
            }
            this.boundSql = boundSql;
            // ★★★ 3. 创建ParameterHandler-参数处理器
            this.parameterHandler = configuration.newParameterHandler(mappedStatement, parameterObject, boundSql);
            // ★★★ 4. 创建ResultSetHandler-结果集处理器
            this.resultSetHandler = configuration.newResultSetHandler(executor, mappedStatement, rowBounds, parameterHandler, resultHandler, boundSql);
          }
    }
    ```
4. Configuration类源码
    ```java
    public class Configuration {
        //1. 创建executor执行器
        public Executor newExecutor(Transaction transaction, ExecutorType executorType) {
            executorType = executorType == null ? defaultExecutorType : executorType;
            executorType = executorType == null ? ExecutorType.SIMPLE : executorType;
            Executor executor;
            if (ExecutorType.BATCH == executorType) {
              executor = new BatchExecutor(this, transaction);
            } else if (ExecutorType.REUSE == executorType) {
              executor = new ReuseExecutor(this, transaction);
            } else {
              executor = new SimpleExecutor(this, transaction);
            }
            if (cacheEnabled) {
              executor = new CachingExecutor(executor);
            }
            executor = (Executor) interceptorChain.pluginAll(executor);
            return executor;
        }
        //2. 创建StatementHandlerSQL语句处理器
        public StatementHandler newStatementHandler(Executor executor, MappedStatement mappedStatement, Object parameterObject, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) {
            StatementHandler statementHandler = new RoutingStatementHandler(executor, mappedStatement, parameterObject, rowBounds, resultHandler, boundSql);
            statementHandler = (StatementHandler) interceptorChain.pluginAll(statementHandler);
            return statementHandler;
        }
        //3. 创建ParameterHandler-参数处理器
        public ParameterHandler newParameterHandler(MappedStatement mappedStatement, Object parameterObject, BoundSql boundSql) {
            ParameterHandler parameterHandler = mappedStatement.getLang().createParameterHandler(mappedStatement, parameterObject, boundSql);
            parameterHandler = (ParameterHandler) interceptorChain.pluginAll(parameterHandler);
            return parameterHandler;
        }
        //4. 创建ResultSetHandler-结果集处理器
        public ResultSetHandler newResultSetHandler(Executor executor, MappedStatement mappedStatement, RowBounds rowBounds, ParameterHandler parameterHandler,
                    ResultHandler resultHandler, BoundSql boundSql) {
            ResultSetHandler resultSetHandler = new DefaultResultSetHandler(executor, mappedStatement, parameterHandler, resultHandler, boundSql, rowBounds);
            resultSetHandler = (ResultSetHandler) interceptorChain.pluginAll(resultSetHandler);
            return resultSetHandler;
        }
    }
    ```
5. InterceptorChain源码
    ```java
    public class InterceptorChain {
        private final List<Interceptor> interceptors = new ArrayList<>();
          public Object pluginAll(Object target) {
          for (Interceptor interceptor : interceptors) {
            target = interceptor.plugin(target);
          }
          return target;
        }
        public void addInterceptor(Interceptor interceptor) {
          interceptors.add(interceptor);
        }
        public List<Interceptor> getInterceptors() {
          return Collections.unmodifiableList(interceptors);
        }
    }
    ```
6. Interceptor源码
    ```java
    public interface Interceptor {
      Object intercept(Invocation invocation) throws Throwable;
      default Object plugin(Object target) {
        return Plugin.wrap(target, this);
      }
      default void setProperties(Properties properties) {
        // NOP
      }
    }
    ```



