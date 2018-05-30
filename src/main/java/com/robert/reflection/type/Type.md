# Java的四种Type
### ParameterizedType
简而言之，就是成员变量使用带有泛型的类
接口中定义了三个方法

Type[] getActualTypeArguments();
获取成员变量的<b>泛型</b>的实际类型

Type getRawType();
获取成员变量实际的类型，即这个成员变量的类类型

Type getOwnerType();
获取外部类的类型，如果没有外部类就是null

具体请看demo

### TypeVariable
就是类上定义了泛型，然后成员变量的类类型就是那个泛型

Type[] getBounds();
即获取类上的泛型设定的范围，如果没设定就是object

AnnotatedType[] getAnnotatedBounds();//这个尚不清楚

具体请看demo

### GenericArrayType
就是上面两种类型的数组类型
Type getGenericComponentType();
获取数组的类型
具体请看demo

### WildCardType
占位符类型，即泛型设置上下边界
具体请看demo