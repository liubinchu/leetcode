/*
package com.leetcode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class zhaoshang02 {


    public class DynamicProxyTest {
        public static void main(String[] args) {
            BondDataImpl bondDynamic = new BondDataImpl();
            DataOperateInterface bondProxy = (DataOperateInterface) Proxy.newProxyInstance(DataOperateInterface.class.getClassLoader(), new Class[]{bondDynamic.getClass().getInterfaces()},
            new DataDynamicProxy);
            bondProxy.updateStatus("BS");
            bondProxy.deleteData("BD");
        }
    }

    //差异接口定义
    interface DataOperateInterface {
        //更新业务状态
        public void updateStatus(String status);

        //删除记录
        public void deleteData(String id);
    }

    //债券业务数据处理类
    class BondDataImpl implements DataOperateInterface {

        @Override
        public void updateStatus(String status) {
            System.out.println("债券--更新状态为：" + status);
        }

        @Override
        public void deleteData(String id) {
            System.out.println("债券--删除记录：" + id);
        }
    }

    //动态代理实现类
    class DataDynamicProxy implements InvocationHandler {

        private Object obj;

        public DataDynamicProxy(Object obj) {
            this.obj = obj;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            WorkFlowClass wf = new WorkFlowClass();
            if ("deleteData".equals(method.getName())) {
                wf.terminateWorkFlow();
            } else {
                wf.submitWorkFlow();
            }
            Object result = method.invoke(obj, args);
            wf.addLog();
            return result;
        }
    }

    //工作流处理类
    class WorkFlowClass {

        public void submitWorkFlow() {
            System.out.println("提交工作流");
        }

        public void terminateWorkFlow() {
            System.out.println("终止工作流");
        }

        public void addLog() {
            System.out.println("记录日志");
        }
    }




}
*/
