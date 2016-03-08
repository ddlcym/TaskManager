package com.changhong.user.service;

import com.changhong.system.web.facade.dto.UserDTO;
import com.changhong.system.web.facade.dto.UserPasswordDTO;
import com.changhong.user.web.facade.dto.PositionDTO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: lenovo
 * Date: 16-3-3
 * Time: 下午4:31
 * To change this template use File | Settings | File Templates.
 */
public interface PositionService {


    PositionDTO obtainPositionById(int positionId);

    List<PositionDTO> obtainAllPositions();

    int obtainPositionSize(String name);

    boolean obtainPositionExist(int positionId, String name);

    void saveOrUpPos(PositionDTO positionDTO);

    void deleteById(int posID);

    void changePosDetails(PositionDTO positionDTO);

    void changeStatusForPosition(int positionId);
}
