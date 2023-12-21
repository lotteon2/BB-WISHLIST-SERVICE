package kr.bb.wishlist.common.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

  @CreatedDate
  @ColumnDefault("now()")
  @Column(name = "created_at", columnDefinition = "TIMESTAMP", nullable = false)
  private LocalDateTime createdAt;

  @LastModifiedDate
  @ColumnDefault("now()")
  @Column(name = "updated_at", columnDefinition = "TIMESTAMP", nullable = false)
  private LocalDateTime updatedAt;

  @Column(name = "is_deleted")
  private Boolean isDeleted = false;

}
