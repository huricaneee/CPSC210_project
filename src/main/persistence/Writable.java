package persistence;

import org.json.JSONObject;

public interface Writable {
    // EFFECTS: return this jason Object
    JSONObject toJson();
}
