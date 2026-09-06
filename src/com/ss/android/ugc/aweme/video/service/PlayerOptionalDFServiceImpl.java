package com.ss.android.ugc.aweme.video.service;

import com.ss.android.ugc.aweme.video.IPlayerOptionalDFService;
import com.ss.ttm.player.plugin.PlayerPlugin;
import java.util.HashSet;

public final class PlayerOptionalDFServiceImpl implements IPlayerOptionalDFService {
    public final boolean LIZ() {
        boolean zContains;
        synchronized (PlayerPlugin.LIZ) {
            zContains = ((HashSet) PlayerPlugin.LIZLLL).contains("xaacdec");
        }
        return zContains;
    }

    public final void init() {
        PlayerPlugin.LIZ("xaacdec");
    }
}
