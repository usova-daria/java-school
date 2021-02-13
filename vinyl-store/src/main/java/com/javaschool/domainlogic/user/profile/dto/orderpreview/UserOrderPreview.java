package com.javaschool.domainlogic.user.profile.dto.orderpreview;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserOrderPreview {

    private UserOrderPreviewInfo orderInfo;

    private List<String> orderItemsPictures;

}
