## SpringBoot事务管理

### @Transaction注解配置

(1) value：指定使用哪种事务管理器，如果使用mybatis集成，则会自动配置
DataSourceTransactionManager

(2)propagation：指定事务的传播属性，默认值为 Propagation.REQUIRED

(3)isolation：指定事务的隔离属性，默认值为Isolation.DEFAULT（使用底层数据默认的隔离级别）

(4)timeout：指定事务的超时时间，默认值是-1，如果超过改时间事务还没有执行完成，则自动执行回滚操作

(5)readOnly：指定事务是否为只读属性，默认值为false，可以忽略像读取数据不需要事务的方法

(6)rollbackFor：指定触发事务回滚的异常类型，可以指定多个异常类型

(7)noRollbackFor：抛出指定的异常类型，可以指定多个异常类型，不回滚事务




