package dommain;

/**
 * @projectName:
 * @fileName:
 * @packageName: Sort
 * @author: Mr.乐
 * @date: 2020/7/9 10:49
 * @copyright(c): 无
 * @versions: 1.0版本
 * @instructions:
 */

public class Sort {
    private int id;
    private String name;
    private int monery;

    public Sort() {

    }

    public Sort(int id, String name, int monery) {
        this.id = id;
        this.name = name;
        this.monery = monery;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMonery() {
        return monery;
    }

    public void setMonery(int monery) {
        this.monery = monery;
    }

    @Override
    public String toString() {
        return "Sort{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", monery=" + monery +
                '}';
    }
}
