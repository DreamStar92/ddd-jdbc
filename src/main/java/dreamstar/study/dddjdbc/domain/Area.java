package dreamstar.study.dddjdbc.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Value;
import lombok.With;
import lombok.experimental.NonFinal;
import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Set;

@Value
@Table("zyy_area")
public class Area {

    @Id
    @With
    Long id;

    String areaName;

    Long parentId;

    @MappedCollection(idColumn = "parent_id", keyColumn = "id")
    Set<Area> childAreas;

    @NonFinal
    @Column("count")
    @Getter(AccessLevel.NONE)
    @AccessType(AccessType.Type.PROPERTY)
    Integer childAreaCount;

    @Transient
    boolean selected = false;

    public Integer getChildAreaCount() {
        return childAreas.size();
    }

    public long noNullCount() {
        return realCount(childAreas);
    }

    private long realCount(Set<Area> areas) {
        return (childAreaCount != null ? 1 : 0) + areas.parallelStream()
                .mapToLong(area -> area.realCount(area.childAreas))
                .sum();
    }

}
