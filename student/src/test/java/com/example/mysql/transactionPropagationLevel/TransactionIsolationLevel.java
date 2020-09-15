package com.example.mysql.transactionPropagationLevel;

/**
 * @description: TransactionIsolationLevel
 * 数据库事务隔离级别有七种
 * @date: 2020/6/18 上午12:20
 * @author: zcy
 * @version: 1.0
 */
public class TransactionIsolationLevel {

    /*----------------支持当前事务 开始-------------------*/
    /**
     * 必须支持事务
     * 如果当前没有事务则新建一个事务；如果以存在一个事务中，加入到这个事务中
     */
    private String PROPAGATION_REQUIRED;

    /**
     * 支持
     * 支持当前事务，如果当前没有事务，则以非事务执行
     */
    private String PROPAGATION_SUPPORT;

    /**
     * 强制
     * 使用当前的事务，如果当前没有事务抛出异常
     */
    private String PROPAGATION_MANDATORY;

    /*----------------支持当前事务 结束-------------------*/

    /*----------------不支持当前事务 开始-------------------*/

    /**
     * 隔离
     * 如果没有事务，新建事务；如果当前事务存在，则把事务挂起
     */
    private String PROPAGATION_REQUIRES_NEW;

    /**
     * 不支持
     * 以非事务的方式执行，如果当前存在事务，则把事务挂起
     */
    private String PROPAGATION_NOT_SUPPORTED;

    /**
     * 强制事务
     * 以非事务的方式执行，如果当前存在事务则抛出异常
     */
    private String PROPAGATION_NEVER;

    /*----------------不支持当前事务 结束-------------------*/

    /*----------------嵌套事务-------------------*/
    /**
     * 嵌套事务
     * 如果当前存在事务，则在嵌套事务内执行。如果当前没有事务与PROPAGATION_REQUIRED相同
     */
    private String PROPAGATION_NESTED;
}
