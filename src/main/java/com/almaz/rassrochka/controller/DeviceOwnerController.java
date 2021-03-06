package com.almaz.rassrochka.controller;

import com.almaz.rassrochka.domain.DeviceOwnerDb;
import com.almaz.rassrochka.service.DeviceOwnerService;
import com.almaz.rassrochka.domain.dto.DeviceOwnerDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.almaz.rassrochka.endpoints.Endpoints.OWNER;

@CrossOrigin
@RestController
@RequestMapping(value = OWNER)
public class DeviceOwnerController {
    private final DeviceOwnerService deviceOwnerService;

    public DeviceOwnerController(DeviceOwnerService deviceOwnerService) {
        this.deviceOwnerService = deviceOwnerService;
    }

    @ApiOperation(value = "Добавить владельца девайса", notes = "Добавить владельца")
    @PostMapping("/addDeviceOwner")
    public DeviceOwnerDb addDeviceOwner(@RequestBody DeviceOwnerDto deviceOwnerDto){
        return deviceOwnerService.addDeviceOwner(deviceOwnerDto);
    }

    @ApiOperation(value = "Получить DeviceOwnerById", notes = "Получить DeviceOwnerById")
    @GetMapping("/getDeviceOwnerById/{id}")
    public List<DeviceOwnerDb> getDeviceOwnerById(@PathVariable Long id) {
        return deviceOwnerService.getDeviceOwnerById(id);
    }
    @ApiOperation(value = "Обновить владельца девайса", notes = "Изменить владельца")
    @PutMapping("/editDeviceOwner")
    public Optional<DeviceOwnerDb> editDeviceOwner(@RequestBody DeviceOwnerDto deviceOwnerDto){
        return deviceOwnerService.editDeviceOwner(deviceOwnerDto);
    }
}
