package com.javaschool.domainlogic.products.record.service.api;

import com.javaschool.domainlogic.products.record.dto.RecordDto;

public interface ShowRecordInfoService {

    RecordDto getRecordById(Long id);

}
