package com.hisense.zxn;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import com.google.gson.Gson;
import com.hisense.zxn.entity.SearchNet;

public class RNSearchModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNSearchModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNSearch";
  }

  @ReactMethod
  public void decode(String word, Promise promise) {
      List<SearchNet> netList = RNSearchManager.getInstance().decode(word);
      WritableMap map = Arguments.createMap();
      if (netList == null || netList.size() == 0) {
          map.putString("status", "0");
          map.putString("result", "no result");
      } else {
          map.putString("status", "0");
          map.putString("result", new Gson().toJson(netList));
      }
      promise.resolve(map);
  }
}