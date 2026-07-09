package com.ss.android.ugc.aweme.video.service;

import com.ss.android.ugc.aweme.video.IM2PlayerComboDFService;
import com.ss.ttm.player.plugin.PlayerPlugin;

public final class M2PlayerComboDFServiceImpl implements IM2PlayerComboDFService {
    public final void init() {
        synchronized (PlayerPlugin.LIZ) {
            PlayerPlugin.LIZ("ttmplayer-plugin");
        }
    }
}
