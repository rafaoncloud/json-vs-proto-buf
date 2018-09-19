package classuc;

public class BenchmarkTimes {

    private final long initialization; // Initialize the serializer/deserializer object
    private final long serialization;
    private final long deserialization;
    private final int serializedSize;

    public BenchmarkTimes(long initialization, long serialization, long deserialization, int serializedSize) {
        this.initialization = initialization;
        this.serialization = serialization;
        this.deserialization = deserialization;
        this.serializedSize = serializedSize;
    }

    public long getInitialization() {
        return initialization;
    }

    public long getSerialization() {
        return serialization;
    }

    public long getDeserialization() {
        return deserialization;
    }

    public int getSerializedSize() {
        return serializedSize;
    }
}
