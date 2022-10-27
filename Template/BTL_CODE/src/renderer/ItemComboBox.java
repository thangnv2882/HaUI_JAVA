package renderer;

public class ItemComboBox {

    private Integer id;
    private String content;

    public ItemComboBox() {
    }

    public ItemComboBox(Integer id, String content) {
        this.id = id;
        this.content = content;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ItemComboBox{" + "id=" + id + ", content=" + content + '}';
    }

}
