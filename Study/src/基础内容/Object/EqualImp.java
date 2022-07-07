package 基础内容.Object;

public class EqualImp {
    private int x;
    private int y;
    private int z;

    public EqualImp(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EqualImp that = (EqualImp) o;

        if (x != that.x) return false;
        if (y != that.y) return false;
        return z == that.z;
    }

    @Override
    public  int hashCode() {
        int result = 17;
        result = result*31 + x;
        result = result*31 + y;
        result = result*31 + z;

        return result;
    }
}
