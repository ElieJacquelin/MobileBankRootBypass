package com.xposed.citibankrootbypass;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class Hook implements IXposedHookLoadPackage {


    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.contains("com.citibank.mobile")) {
            return;
        }

        findAndHookMethod("org.apache.cordova.plugin.AppUtilsPlugin", lpparam.classLoader, "checkRootSU", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                return false;
            }
        });

        findAndHookMethod("org.apache.cordova.plugin.AppUtilsPlugin", lpparam.classLoader, "checkRootBuildTags", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                return false;
            }
        });

        findAndHookMethod("org.apache.cordova.plugin.AppUtilsPlugin", lpparam.classLoader, "checkRootSUApps", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                return false;
            }
        });

        findAndHookMethod("org.apache.cordova.plugin.AppUtilsPlugin", lpparam.classLoader, "checkRootSUCommands", new XC_MethodReplacement() {
            @Override
            protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
                return false;
            }
        });
    }
}
