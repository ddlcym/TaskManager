package com.changhong.user.service;

import com.changhong.user.web.facade.dto.PositionDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: lenovo
 * Date: 16-3-4
 * Time: 下午2:57
 * To change this template use File | Settings | File Templates.
 */
@Service("positionService")
public class PositionServiceImpl implements PositionService{


    public PositionDTO obtainPositionById(int positionId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<PositionDTO> obtainPositions(String name, int startPosition, int pageSize) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int obtainPositionSize(String name) {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean obtainPositionExist(int positionId, String name) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void changePositionDetails(PositionDTO positionDTO) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void changeStatusForPosition(int positionId) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
