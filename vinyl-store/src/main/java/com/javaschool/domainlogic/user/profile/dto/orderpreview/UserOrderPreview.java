package com.javaschool.domainlogic.user.profile.dto.orderpreview;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * @author Daria Usova
 */
@Data
@AllArgsConstructor
public class UserOrderPreview {

    /**
     * Order info
     */
    private UserOrderPreviewInfo orderInfo;

    /**
     * List of order items
     */
    private List<String> orderItemsPictures;

}
