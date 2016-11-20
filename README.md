# MustSucc
1.utils 包里面实现大部分关键字的逻辑
2.webdriverapi重新包装了一些webdriver的方法，对应acton的mapper，这样添加action就比较的简单了
3.实现关键字的技术：反射，通过methodName 映射方法
4.怎么组织case：去数据库以case为单位 查出step step的顺序怎么保证呢，order by path，然后用有序的hashlinkedmap去存储
5.怎么去设置断言和获取结果呢。在case里面不做断言，在quit浏览器的时候，获取case目标的结果，存储在case表中。这样将结果的模块独立成一个单独的接口
6.关于异常的处理，在webdriver一层只往外抛出异常
7.DAO和controller 以及services,都是基于spring+srpingmvc+mybatis管理的，都是以实体为单位：case step case project，page，element
8.那么怎么使用扩展自己需要的东西呢
8.1：扩展webdriver的api，然后再actionmap 添加对应的mapper，然后就可以定义出新的关键字
9.怎么去操作呢：
9.1粗糙的，表单，实现提交，查询，执行接口。最好都是以project去关联所有东西
10.有问题就留言吧。

please fork or star
