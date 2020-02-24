# Smart_toast


## Gradle 


Step 1. Add the JitPack repository in your root build.gradle at the end of repositories:
    
    
    
    
    allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}



Step 2. Add the dependency

	        implementation 'com.github.developer5167:Smart_toast:1.0.0'
		
		
		
###### JAVA

## Usage


	Smart_Toast smart_toast;
	smart_toast = new Smart_Toast(this, "This is Success toast");
        smart_toast.setToastStyle(Smart_Toast.SQUARE);
        smart_toast.setTextColor(Color.BLACK);
        smart_toast.setToastType(Smart_Toast.SUCCESS);
        smart_toast.setappIcon("YOUR APP ICON HERE");
        smart_toast.setbackgroundColor(Color.BLUE);
        smart_toast.setDuration(Smart_Toast.MUCH_LONGER);
        smart_toast.setFontFamily("YOUR TYPEFACE");
        smart_toast.show();
