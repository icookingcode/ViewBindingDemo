# ViewBindingDemo
ViewBinding封装
# gradle引入
## Add it in your root build.gradle at the end of repositories:
To use this frmame,add this dependency to the build.gradle of the app:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
## Add the dependency
```
 implementation 'com.gitee.guclib:gviewbinding:1.0.0'
```
# 启用ViewBinding
```
  android{
    ......
    buildFeatures {
        viewBinding = true  //启用viewBinding
    }
    ......
  }
```
# 使用
## Activity中使用(Dialog用法与之相同)
```
  private val binding: ActivityMainBinding by inflate()

  binding.tvShow.text = "Hello Guc!"  //tvShow为布局中控件ID
```
## Fragment中使用
```
  private val binding: FragmentMainBinding by bindView()
  binding.tvShow.text = "HelloWorld!"  //tvShow为布局中控件ID
```
## RecyclerView.Adapter中使用
* 加载不同ViewType的布局
```

 class CustomAdapter:BindingCommonAdapter<String>(listOf("苹果", "香蕉", "橘子", "榴莲", "柠檬")) {
        override fun getItemViewType(position: Int): Int {
            return position%2
        }
        override fun createBindingViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): BindingViewHolder<ViewBinding> {
            return  if (viewType == 0)  newBindingViewHolder<ItemTextBinding>(parent) else newBindingViewHolder<ItemText2Binding>(parent)
        }

        override fun bindData(
            viewHolder: BindingViewHolder<ViewBinding>,
            position: Int,
            data: String,
            itemType: Int
        ) {
            if (viewHolder.binding is ItemTextBinding){
                //加载数据
                viewHolder.binding.tvText.text = data
            }else if (viewHolder.binding is ItemText2Binding){
                //加载数据
                viewHolder.binding.tvText2.text = data
            }
        }
    }
```
* 加载同一种列表布局
```

 class CustomAdapter:BindingCommonAdapter<String>(listOf("苹果", "香蕉", "橘子", "榴莲", "柠檬")) {
        override fun createBindingViewHolder(
            parent: ViewGroup,
            viewType: Int
        ): BindingViewHolder<ViewBinding> {
            return  newBindingViewHolder<ItemTextBinding>(parent)
        }

        override fun bindData(
            viewHolder: BindingViewHolder<ViewBinding>,
            position: Int,
            data: String,
            itemType: Int
        ) {
            (viewHolder.binding as ItemTextBinding).apply{
                //加载数据
                viewHolder.binding.tvText.text = data
            }
        }
    }
```
# 代码混淆
```
# 防止反射方法被混淆
-keepclassmembers class * implements androidx.viewbinding.ViewBinding {
  public static * inflate(android.view.LayoutInflater);
  public static * inflate(android.view.LayoutInflater, android.view.ViewGroup, boolean);
  public static * bind(android.view.View);
}
```

# 关于我  
Name: Guchao  
Email: happygc913@gmail.com / happygc@126.com  
CSDN: [snow_lyGirl](https://blog.csdn.net/qq_31028313)  
GitHub: [GuchaoGit](https://github.com/GuchaoGit?tab=repositories)  
Gitee:[GuChaoGitee](https://gitee.com/guchaogitee/projects)  
加入QQ群:128937635  