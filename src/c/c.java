package c;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public final class c {
    public final String a;
    public int b;

    public c(String str) {
        this.a = str;
    }

    public final void a() {
        while (this.b < this.a.length()) {
            char cCharAt = this.a.charAt(this.b);
            if (cCharAt != ' ' && cCharAt != '\n' && cCharAt != '\r' && cCharAt != '\t') {
                return;
            } else {
                this.b++;
            }
        }
    }

    public final String b() {
        b('\"');
        StringBuilder sb = new StringBuilder();
        while (this.b < this.a.length()) {
            String str = this.a;
            int i = this.b;
            this.b = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt == '\"') {
                return sb.toString();
            }
            if (cCharAt < ' ') {
                a("Control character in string");
                throw null;
            }
            if (cCharAt != '\\') {
                sb.append(cCharAt);
            } else {
                if (this.b >= this.a.length()) {
                    a("Truncated escape");
                    throw null;
                }
                String str2 = this.a;
                int i2 = this.b;
                this.b = i2 + 1;
                char cCharAt2 = str2.charAt(i2);
                switch (cCharAt2) {
                    case '\"':
                    case '/':
                    case '\\':
                        sb.append(cCharAt2);
                        break;
                    case 'b':
                        sb.append('\b');
                        break;
                    case 'f':
                        sb.append('\f');
                        break;
                    case 'n':
                        sb.append('\n');
                        break;
                    case 'r':
                        sb.append('\r');
                        break;
                    case 't':
                        sb.append('\t');
                        break;
                    case 'u':
                        if (this.b + 4 > this.a.length()) {
                            a("Truncated unicode escape");
                            throw null;
                        }
                        try {
                            String str3 = this.a;
                            int i3 = this.b;
                            sb.append((char) Integer.parseInt(str3.substring(i3, i3 + 4), 16));
                            this.b += 4;
                        } catch (NumberFormatException e) {
                            a("Invalid unicode escape");
                            throw null;
                        }
                        break;
                        break;
                    default:
                        a("Invalid escape");
                        throw null;
                }
            }
        }
        a("Unterminated string");
        throw null;
    }

    public final Serializable c() {
        boolean z;
        a();
        if (this.b >= this.a.length()) {
            a("Missing value");
            throw null;
        }
        char cCharAt = this.a.charAt(this.b);
        boolean z2 = true;
        if (cCharAt == '{') {
            this.b++;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            a();
            if (!a('}')) {
                while (true) {
                    a();
                    if (this.b >= this.a.length() || this.a.charAt(this.b) != '\"') {
                        a("Object key expected");
                        throw null;
                    }
                    String strB = b();
                    if (linkedHashMap.containsKey(strB)) {
                        a(a.a.a("j+BsAdMytIHpMpn8jS4SN+b5pUC+2GWfFgvxRpavqG8=", "PfcdAE0IDe4PLMVb", "aes", new StringBuilder(), strB));
                        throw null;
                    }
                    a();
                    b(':');
                    linkedHashMap.put(strB, c());
                    a();
                    if (a('}')) {
                        break;
                    }
                    b(',');
                }
            }
            return linkedHashMap;
        }
        if (cCharAt == '[') {
            this.b++;
            ArrayList arrayList = new ArrayList();
            a();
            if (!a(']')) {
                while (true) {
                    arrayList.add(c());
                    a();
                    if (a(']')) {
                        break;
                    }
                    b(',');
                }
            }
            return arrayList;
        }
        if (cCharAt == '\"') {
            return b();
        }
        if (cCharAt != '-' && !Character.isDigit(cCharAt)) {
            String strDecrypt = "true";
            if (this.a.startsWith(strDecrypt, this.b)) {
                this.b = strDecrypt.length() + this.b;
                return Boolean.TRUE;
            }
            String strDecrypt2 = "false";
            if (this.a.startsWith(strDecrypt2, this.b)) {
                this.b = strDecrypt2.length() + this.b;
                return Boolean.FALSE;
            }
            String strDecrypt3 = "null";
            if (this.a.startsWith(strDecrypt3, this.b)) {
                this.b = strDecrypt3.length() + this.b;
                return null;
            }
            a("Unexpected token");
            throw null;
        }
        int i = this.b;
        if (a('-') && this.b >= this.a.length()) {
            a("Truncated number");
            throw null;
        }
        if (a('0')) {
            if (this.b < this.a.length() && Character.isDigit(this.a.charAt(this.b))) {
                a("Leading zero");
                throw null;
            }
        } else {
            if (this.b >= this.a.length() || !Character.isDigit(this.a.charAt(this.b))) {
                a("Invalid number");
                throw null;
            }
            while (this.b < this.a.length() && Character.isDigit(this.a.charAt(this.b))) {
                this.b++;
            }
        }
        if (!a('.')) {
            z = false;
        } else {
            if (this.b >= this.a.length() || !Character.isDigit(this.a.charAt(this.b))) {
                a("Invalid fraction");
                throw null;
            }
            while (this.b < this.a.length() && Character.isDigit(this.a.charAt(this.b))) {
                this.b++;
            }
            z = true;
        }
        if (this.b >= this.a.length() || !(this.a.charAt(this.b) == 'e' || this.a.charAt(this.b) == 'E')) {
            z2 = z;
        } else {
            int i2 = this.b + 1;
            this.b = i2;
            if (i2 < this.a.length() && (this.a.charAt(this.b) == '+' || this.a.charAt(this.b) == '-')) {
                this.b++;
            }
            if (this.b >= this.a.length() || !Character.isDigit(this.a.charAt(this.b))) {
                a("Invalid exponent");
                throw null;
            }
            while (this.b < this.a.length() && Character.isDigit(this.a.charAt(this.b))) {
                this.b++;
            }
        }
        try {
            String strSubstring = this.a.substring(i, this.b);
            return z2 ? Double.valueOf(strSubstring) : Long.valueOf(strSubstring);
        } catch (NumberFormatException e) {
            a("Invalid number");
            throw null;
        }
    }

    public final boolean a(char c2) {
        if (this.b >= this.a.length() || this.a.charAt(this.b) != c2) {
            return false;
        }
        this.b++;
        return true;
    }

    public final void a(String str) {
        throw new IOException(str + " at JSON offset " + this.b);
    }

    public final void b(char c2) {
        if (a(c2)) {
            return;
        }
        a("Expected '" + c2 + "'");
        throw null;
    }
}
