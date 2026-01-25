package fake.com.bytedance.ttc2pa;

import fake.d.c;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class TTC2PAManifestInfo {
    public List assertions;
    public String claim_generator;
    public Set claim_generator_info;
    public Set component_ingredients;
    public String input_file;
    public String output_file;
    public String parent_ingredient;

    public static final class Action {
        public String action;
        public String changed;
        public String digitalSourceType;
        public Map parameters;
        public String reason;
        public SoftwareAgent softwareAgent;
        public String when;

        public static final class SoftwareAgent {
            public String name;
            public Map other;
            public String version;

            public final String getName() {
                String str = this.name;
                if (str != null) {
                    return str;
                }
                c.a("name");
                throw null;
            }

            public final Map getOther() {
                return this.other;
            }

            public final String getVersion() {
                return this.version;
            }

            public final void setName(String str) {
                c.b(str, "<set-?>");
                this.name = str;
            }

            public final void setOther(Map map) {
                this.other = map;
            }

            public final void setVersion(String str) {
                this.version = str;
            }
        }

        public final String getAction() {
            String str = this.action;
            if (str != null) {
                return str;
            }
            c.a("action");
            throw null;
        }

        public final String getChanged() {
            return this.changed;
        }

        public final String getDigitalSourceType() {
            return this.digitalSourceType;
        }

        public final Map getParameters() {
            return this.parameters;
        }

        public final String getReason() {
            return this.reason;
        }

        public final SoftwareAgent getSoftwareAgent() {
            return this.softwareAgent;
        }

        public final String getWhen() {
            return this.when;
        }

        public final void setAction(String str) {
            c.b(str, "<set-?>");
            this.action = str;
        }

        public final void setChanged(String str) {
            this.changed = str;
        }

        public final void setDigitalSourceType(String str) {
            this.digitalSourceType = str;
        }

        public final void setParameters(Map map) {
            this.parameters = map;
        }

        public final void setReason(String str) {
            this.reason = str;
        }

        public final void setSoftwareAgent(SoftwareAgent softwareAgent) {
            this.softwareAgent = softwareAgent;
        }

        public final void setWhen(String str) {
            this.when = str;
        }
    }

    public static final class ClaimGeneratorInfo {
        public String name;
        public String version;

        public final String getName() {
            String str = this.name;
            if (str != null) {
                return str;
            }
            c.a("name");
            throw null;
        }

        public final String getVersion() {
            return this.version;
        }

        public final void setName(String str) {
            c.b(str, "<set-?>");
            this.name = str;
        }

        public final void setVersion(String str) {
            this.version = str;
        }
    }

    public static final class ManifestAssertion {
        public Object data;
        public String label;

        public final Object getData() {
            Object obj = this.data;
            if (obj != null) {
                return obj;
            }
            c.a("data");
            throw null;
        }

        public final String getLabel() {
            String str = this.label;
            if (str != null) {
                return str;
            }
            c.a("label");
            throw null;
        }

        public final void setData(Object obj) {
            c.b(obj, "<set-?>");
            this.data = obj;
        }

        public final void setLabel(String str) {
            c.b(str, "<set-?>");
            this.label = str;
        }
    }

    public final List getAssertions() {
        List list = this.assertions;
        if (list != null) {
            return list;
        }
        c.a("assertions");
        throw null;
    }

    public final String getClaim_generator() {
        return this.claim_generator;
    }

    public final Set getClaim_generator_info() {
        return this.claim_generator_info;
    }

    public final Set getComponent_ingredients() {
        return this.component_ingredients;
    }

    public final String getInput_file() {
        String str = this.input_file;
        if (str != null) {
            return str;
        }
        c.a("input_file");
        throw null;
    }

    public final String getOutput_file() {
        String str = this.output_file;
        if (str != null) {
            return str;
        }
        c.a("output_file");
        throw null;
    }

    public final String getParent_ingredient() {
        return this.parent_ingredient;
    }

    public final void setAssertions(List list) {
        c.b(list, "<set-?>");
        this.assertions = list;
    }

    public final void setClaim_generator(String str) {
        this.claim_generator = str;
    }

    public final void setClaim_generator_info(Set set) {
        this.claim_generator_info = set;
    }

    public final void setComponent_ingredients(Set set) {
        this.component_ingredients = set;
    }

    public final void setInput_file(String str) {
        c.b(str, "<set-?>");
        this.input_file = str;
    }

    public final void setOutput_file(String str) {
        c.b(str, "<set-?>");
        this.output_file = str;
    }

    public final void setParent_ingredient(String str) {
        this.parent_ingredient = str;
    }
}
