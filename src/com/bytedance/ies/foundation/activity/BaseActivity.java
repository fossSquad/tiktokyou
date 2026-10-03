package com.bytedance.ies.foundation.activity;

import android.app.Activity;

/**
 * Compile-time shadow of the host BaseActivity.
 *
 * The dex2jar build of the host class extends digit-prefixed X.* classes
 * (X.03IS, X.03IT, X.03IU, X.03IV) that javac cannot read, which breaks the
 * Activity/Context hierarchy for every mod class extending BaseActivity.
 * This stub restores the hierarchy for compilation only; at runtime the
 * host's real BaseActivity is used.
 */
public class BaseActivity extends Activity {
}
