package com.sevtinge.hyperceiler.module.app;

import android.text.TextUtils;

import com.sevtinge.hyperceiler.module.base.BaseModule;
import com.sevtinge.hyperceiler.module.hook.packageinstaller.AllAsSystemApp;
import com.sevtinge.hyperceiler.module.hook.packageinstaller.DisableAD;
import com.sevtinge.hyperceiler.module.hook.packageinstaller.DisableCountChecking;
import com.sevtinge.hyperceiler.module.hook.packageinstaller.DisableSafeModelTip;
import com.sevtinge.hyperceiler.module.hook.packageinstaller.DisplayMoreApkInfoNew;
import com.sevtinge.hyperceiler.module.hook.packageinstaller.InstallRiskDisable;
import com.sevtinge.hyperceiler.module.hook.packageinstaller.InstallSource;

public class PackageInstaller extends BaseModule {

    public void handleLoadPackage() {

        //
        /*initHook(new MiuiPackageInstallModify(), mPrefsMap.getBoolean("miui_package_installer_modify"));*/

        // 禁用广告
        initHook(DisableAD.INSTANCE, mPrefsMap.getBoolean("miui_package_installer_disable_ad"));

        // 禁用风险检测
        initHook(InstallRiskDisable.INSTANCE, mPrefsMap.getBoolean("miui_package_installer_install_risk"));

        // 禁用安全守护提示
        initHook(DisableSafeModelTip.INSTANCE, mPrefsMap.getBoolean("miui_package_installer_safe_model_tip"));

        // 允许更新系统应用
        initHook(AllAsSystemApp.INSTANCE, mPrefsMap.getBoolean("miui_package_installer_update_system_app"));

        // 自定义安装来源
        initHook(new InstallSource(), !TextUtils.isEmpty(mPrefsMap.getString("miui_package_installer_install_source", "com.android.fileexplorer")));

        // 显示更多安装包信息
        // initHook(new DisplayMoreApkInfo(), mPrefsMap.getBoolean("miui_package_installer_apk_info"));
        initHook(DisplayMoreApkInfoNew.INSTANCE, mPrefsMap.getBoolean("miui_package_installer_apk_info"));

        // 禁用频繁安装应用检查
        initHook(DisableCountChecking.INSTANCE, mPrefsMap.getBoolean("miui_package_installer_count_checking"));

    }
}
