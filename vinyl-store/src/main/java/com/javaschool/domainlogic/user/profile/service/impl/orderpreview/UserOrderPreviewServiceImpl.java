package com.javaschool.domainlogic.user.profile.service.impl.orderpreview;

import com.javaschool.dao.api.order.OrderRepository;
import com.javaschool.domainlogic.user.profile.dto.orderpreview.UserOrderPreview;
import com.javaschool.domainlogic.user.profile.dto.orderpreview.UserOrderPreviewInfo;
import com.javaschool.domainlogic.user.profile.service.api.orderpreview.UserOrderPreviewService;
import com.javaschool.entity.user.User;
import com.javaschool.service.api.UserService;
import com.javaschool.util.PictureEncoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Log4j
@Service
@RequiredArgsConstructor
public class UserOrderPreviewServiceImpl implements UserOrderPreviewService {

    private static final int NUMBER_OF_ITEMS_TO_SHOW = 3;

    private final UserService userService;
    private final OrderRepository orderRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UserOrderPreview> getOrdersOfCurrentUser() {
        try {
            return tryToGetOrdersOfCurrentUser();
        } catch (PersistenceException e) {
            log.error("An error occurred while getting orders of current user", e);
            return new ArrayList<>();
        }
    }

    private List<UserOrderPreview> tryToGetOrdersOfCurrentUser() {
        User user = userService.getCurrentUser();
        List<UserOrderPreviewInfo> orderInfoList =
                orderRepository.findUserOrderPreviewInfoByUserId(user.getId());

        return orderInfoList.stream()
                .map(this::getOrderPreviewPictures)
                .collect(Collectors.toList());
    }

    private UserOrderPreview getOrderPreviewPictures(UserOrderPreviewInfo orderInfo) {
        List<byte[]> pictures =
                orderRepository.findOrderItemPicturesByOrderId(orderInfo.getOrderId(), NUMBER_OF_ITEMS_TO_SHOW);
        return new UserOrderPreview(orderInfo, PictureEncoder.toStringList(pictures));
    }

}
