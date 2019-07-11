
# react-native-search-baidu

## Getting started

`$ npm install react-native-search-baidu --save`

### Mostly automatic installation

`$ react-native link react-native-search-baidu`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-search-baidu` and add `RNSearchBaidu.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNSearchBaidu.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.hisense.zxn.RNSearchBaiduPackage;` to the imports at the top of the file
  - Add `new RNSearchBaiduPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-search-baidu'
  	project(':react-native-search-baidu').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-search-baidu/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-search-baidu')
  	```


## Usage
```javascript
import RNSearchBaidu from 'react-native-search-baidu';

// TODO: What to do with the module?
RNSearchBaidu;
```
  