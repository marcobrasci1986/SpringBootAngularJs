package be.ordina.domain;

import javax.persistence.*;

/**
 * Created by MaBa on 15/03/2016.
 */

@Entity
public class Item extends AbstractEntity{

    @Column
    private boolean checked;
    @Column
    private String description;

    public Item() {
    }

    public Item(boolean checked, String description) {
        this.checked = checked;
        this.description = description;
    }


    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (checked != item.checked) return false;
        return description != null ? description.equals(item.description) : item.description == null;

    }

    @Override
    public int hashCode() {
        int result = (checked ? 1 : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
