public class AsciiCharSequence implements CharSequence {
    private final byte[] values;

    public AsciiCharSequence(byte[] values) {
        this.values = values;
    }

    @Override
    public int length() {
        return values.length;
    }

    @Override
    public char charAt(int index) {
        return (char) values[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        byte[] target = new byte[end - start];
        for (int i = 0, j = start; j < end && j < values.length; i++, j++) {
            target[i] = values[j];
        }
        return new AsciiCharSequence(target);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (byte value : values) {
            builder.append((char) value);
        }
        return builder.toString();
    }
}