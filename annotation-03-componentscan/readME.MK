作用:
	用于指定创建容器时要扫描的包.该注解在指定扫描的位置时,可以指定包名,也可以指定扫描的类.同时支持定义扫描规则,例如包含哪些或者排除哪些.
	同时,它还支持自定义Bean的命名规则
属性:
	value:
		用于指定要扫描的包.当指定了包的名称之后,spring会扫描指定的包及其子包下的所有类.
	basePackages:
		它和value作用是一样的.
	basePackageClasses:
		指定具体要扫描的类的字节码.
	nameGenrator:
		指定扫描bean对象存入容器时的命名规则.详情请参考第五章第4小节的BeanNameGenerator及其实现类.
	scopeResolver:
		用于处理并转换检测到的Bean的作用范围.
	soperdProxy:
		用于指定bean生成时的代理方式.默认是Default,则不使用代理.详情请参考第五章第5小节ScopedProxyMode枚举.
	resourcePattern:
		用于指定符合组件检测条件的类文件,默认是包扫描下的  **/*.class
	useDefaultFilters:
		是否对带有@Component @Repository @Service @Controller注解的类开启检测,默认是开启的.
	includeFilters:
		自定义组件扫描的过滤规则,用以扫描组件.
		FilterType有5种类型:
            ANNOTATION, 注解类型 默认
            ASSIGNABLE_TYPE,指定固定类
            ASPECTJ, ASPECTJ类型
            REGEX,正则表达式
            CUSTOM,自定义类型
        详细用法请参考第五章第6小节自定义组件扫描过滤规则
	excludeFilters:
		自定义组件扫描的排除规则.
	lazyInit:
		组件扫描时是否采用懒加载 ,默认不开启.
使用场景:
	在注解驱动开发时,我们自己编写的类都使用注解的方式进行配置,要想让spring添加到ioc容器中,就需要使用此注解来实现组件的扫描.
细节:
	在spring4.3版本之后还加入了一个@ComponentScans的注解,该注解就是支持配置多个@ComponentScan.