# 开始学习spring源码

开始学习spring源码，记录学习过程。

## spring源码分析的环境搭建

### idea的环境
1. 下载源码

2. 源码目录下的文件import-into-idea.md有说明

3. 预编译pring-oxm，进入源码目录，执行

```bash
./gradlew :spring-oxm:compileTestJava
或
gradlew.bat :spring-oxm:compileTestJava
```
会自动下载gradle

4. 导入idea, File -> New -> Project from Existing Sources -> 找到目录 -> 选择 build.gradle

gradle的设置，最好使用默认的就可以，之后idea会自动扫描，等扫描结束，在gradle视图能看到一个名叫spring的gradle项目，下面包含多个子项目
例如spring-core, spring-context等

5. 编译整个项目，执行Build -> Build Project(command+F9)，这一步不是必须的，但不执行这一步，到第6步的时候，执行会报错。在执行过程中
会报错，适合aspectj相关的，可以不用管，不影响后面的操作。对aspectj到底有什么影响，到分析aspectj源码的时候就知道了。

6. 此时基本都导入完成了。添加一个自己的项目，用于测试：

    1. 添加模块01-helloworld，选择gradle项目，作为spring的子模块
  
    2. Finish之后等待执行结束，在项目的根目录下，打开settings.gradle，最后面发现加入了_include '01-helloworld'_表示添加模块成功
  
    3. 刚添加模块文件夹下，在build.gradle中添加
  
      ```groovy
      dependencies {
          // 引入其他模块，用来测试是否成功导入了spring
          compile(project(":spring-context"))
          compile(project(":spring-test"))
          testCompile group: 'junit', name: 'junit', version: '4.12'
          // 不知道跟上面的配置有什么区别，表现出来的是，上面的写法只是把junit4.12引入，但junit4.12的依赖hamcrest-core没有引入
          testImplementation 'junit:junit:4.12'
      }
      ```
  
    4. 添加UserService.java，如果成功导入了spring，UserService这个类就可以import Spring相关的类，比如@Component，否则会提示找不到类
  
    5. 之后就可以测试了，测试成功，表示导入spring源码没有问题，否则，自求多福了
  
### eclipse的环境