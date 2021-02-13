package com.javaschool.domainlogic.user.profile.service.impl;

import com.javaschool.dao.api.order.OrderRepository;
import com.javaschool.domainlogic.user.profile.dto.orderpreview.UserOrderPreview;
import com.javaschool.domainlogic.user.profile.dto.orderpreview.UserOrderPreviewInfo;
import com.javaschool.domainlogic.user.profile.service.api.UserOrderPreviewService;
import com.javaschool.entity.user.User;
import com.javaschool.service.api.UserService;
import com.javaschool.util.PictureEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserOrderPreviewServiceImpl implements UserOrderPreviewService {

    private final int NUMBER_OF_ITEMS_TO_SHOW = 3;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UserOrderPreview> getOrdersOfCurrentUser() {
        User user = userService.getCurrentUser();
        List<UserOrderPreviewInfo> orderInfoList =
                orderRepository.findUserOrderPreviewInfoByUserId(user.getId());

        return orderInfoList.stream()
                .map(info -> {
                    List<byte[]> pictures =
                            orderRepository.findOrderItemPicturesByOrderId(info.getOrderId(), NUMBER_OF_ITEMS_TO_SHOW);
                    return new UserOrderPreview(info, PictureEncoder.toStringList(pictures));
                })
                .collect(Collectors.toList());

    }

}
