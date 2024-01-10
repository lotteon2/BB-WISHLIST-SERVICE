package kr.bb.wishlist.common.util;

import org.springframework.data.domain.Pageable;

public class PaginationUtil {

    public static int calculateLimitStart(Pageable pageable) {
        return pageable.getPageNumber() * pageable.getPageSize();
    }

    public static int calculateLimitEnd(Pageable pageable, int totalItems) {
        int limitEnd = (pageable.getPageNumber() + 1) * pageable.getPageSize();
        return Math.min(limitEnd, totalItems);
    }
}