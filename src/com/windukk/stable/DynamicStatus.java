package com.windukk.stable;

public final class DynamicStatus {
    public final String activeSha256;
    public final long activeVersion;
    public final String bundledSha256;
    public final long bundledVersion;
    public final String pendingSha256;
    public final long pendingVersion;
    public final String previousSha256;
    public final long previousVersion;
    public final boolean unfinishedStartup;

    public DynamicStatus(String str, String str2, String str3, String str4, boolean z, long j, long j2, long j3, long j4) {
        this.bundledSha256 = str;
        this.activeSha256 = str2;
        this.previousSha256 = str3;
        this.pendingSha256 = str4;
        this.unfinishedStartup = z;
        this.bundledVersion = j;
        this.activeVersion = j2;
        this.previousVersion = j3;
        this.pendingVersion = j4;
    }

    public final String summary() {
        StringBuilder sbAppend = new StringBuilder().append("bundled=");
        String str = this.bundledSha256;
        StringBuilder sbAppend2 = sbAppend.append(str == null ? "none" : str.substring(0, Math.min(12, str.length()))).append("@").append(this.bundledVersion).append("\nactive=");
        String str2 = this.activeSha256;
        StringBuilder sbAppend3 = sbAppend2.append(str2 == null ? "none" : str2.substring(0, Math.min(12, str2.length()))).append("@").append(this.activeVersion).append("\nprevious=");
        String str3 = this.previousSha256;
        StringBuilder sbAppend4 = sbAppend3.append(str3 == null ? "none" : str3.substring(0, Math.min(12, str3.length()))).append("@").append(this.previousVersion).append("\npending=");
        String str4 = this.pendingSha256;
        return sbAppend4.append(str4 == null ? "none" : str4.substring(0, Math.min(12, str4.length()))).append("@").append(this.pendingVersion).append("\nunfinishedStartup=").append(this.unfinishedStartup).toString();
    }
}
