package com.windukk.stable;
public final class DynamicStatus {
    public final String activeSha256;
    public final String bundledSha256;
    public final String pendingSha256;
    public final String previousSha256;
    public final boolean unfinishedStartup;

    public DynamicStatus(String str, String str2, String str3, String str4, boolean z) {
        this.bundledSha256 = str;
        this.activeSha256 = str2;
        this.previousSha256 = str3;
        this.pendingSha256 = str4;
        this.unfinishedStartup = z;
    }

    public final String summary() {
        StringBuilder sbAppend = new StringBuilder().append("bundled=");
        String str = this.bundledSha256;
        StringBuilder sbAppend2 = sbAppend.append(str == null ? "none" : str.substring(0, Math.min(12, str.length()))).append("\nactive=");
        String str2 = this.activeSha256;
        StringBuilder sbAppend3 = sbAppend2.append(str2 == null ? "none" : str2.substring(0, Math.min(12, str2.length()))).append("\nprevious=");
        String str3 = this.previousSha256;
        StringBuilder sbAppend4 = sbAppend3.append(str3 == null ? "none" : str3.substring(0, Math.min(12, str3.length()))).append("\npending=");
        String str4 = this.pendingSha256;
        return sbAppend4.append(str4 == null ? "none" : str4.substring(0, Math.min(12, str4.length()))).append("\nunfinishedStartup=").append(this.unfinishedStartup).toString();
    }
}
