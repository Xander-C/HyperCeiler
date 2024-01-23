package com.sevtinge.hyperceiler.module.app;

import com.sevtinge.hyperceiler.module.base.BaseModule;
import com.sevtinge.hyperceiler.module.hook.mediaeditor.CustomWatermark;
import com.sevtinge.hyperceiler.module.hook.mediaeditor.FilterManagerAll;
import com.sevtinge.hyperceiler.module.hook.mediaeditor.UnlockCustomPhotoFrames;
import com.sevtinge.hyperceiler.module.hook.mediaeditor.UnlockDisney;
import com.sevtinge.hyperceiler.module.hook.mediaeditor.UnlockLeicaFilter;
import com.sevtinge.hyperceiler.module.hook.mediaeditor.UnlockMinimumCropLimitNew;

import java.util.Objects;

public class MediaEditor extends BaseModule {

    @Override
    public void handleLoadPackage() {
        // 基础
        initHook(UnlockMinimumCropLimitNew.INSTANCE, mPrefsMap.getBoolean("mediaeditor_unlock_minimum_crop_limit"));
        initHook(FilterManagerAll.INSTANCE, mPrefsMap.getBoolean("mediaeditor_filter_manager"));
        initHook(UnlockLeicaFilter.INSTANCE, mPrefsMap.getBoolean("mediaeditor_unlock_leica_filter"));
        initHook(CustomWatermark.INSTANCE, !Objects.equals(mPrefsMap.getString("mediaeditor_custom_watermark", ""), ""));
        // AI 创作
        initHook(UnlockCustomPhotoFrames.INSTANCE, mPrefsMap.getStringAsInt("mediaeditor_unlock_custom_photo_frames", 0) != 0);
        initHook(UnlockDisney.INSTANCE, mPrefsMap.getBoolean("mediaeditor_unlock_disney"));
    }

}


