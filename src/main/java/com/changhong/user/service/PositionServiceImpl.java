package com.changhong.user.service;

import com.changhong.user.domain.Position;
import com.changhong.user.repository.PositionDao;
import com.changhong.user.web.facade.assember.PositionWebAssember;
import com.changhong.user.web.facade.dto.PositionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: lenovo
 * Date: 16-3-4
 * Time: 下午2:57
 * To change this template use File | Settings | File Templates.
 */
@Service("positionService")
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionDao positionDao;

    public PositionDTO obtainPositionById(int positionId) {
        Position pos = (Position) positionDao.findById(positionId, Position.class);
        return PositionWebAssember.toPosDTO(pos);  //To change body of implemented methods use File | Settings | File Templates.
    }

    public List<PositionDTO> obtainAllPositions() {
        List<Position> posDomainList = positionDao.loadAllCategory();
        return PositionWebAssember.toPosDTOList(posDomainList);  //To change body of implemented methods use File | Settings | File Templates.
    }

    public int obtainPositionSize(String name) {
        return 0;
    }

//    public boolean obtainPositionExist(int positionId, String name) {
//        boolean flag = false;
//        if (positionId > 0&& StringUtils.hasText(name)) {
//            Position pos = (Position) positionDao.findById(positionId, Position.class);
//            if(name.equals(pos.getName())){
//                flag=true;
//            }
//        }
//        return flag;
//    }

    public void saveOrUpPos(PositionDTO positionDTO) {
        Position pos = PositionWebAssember.toPosDomain(positionDTO);
        positionDao.saveOrUpdate(pos);

    }

    public void deleteById(int posID) {
        if (posID < 0)
            return;
        Position pos = (Position) positionDao.findById(posID, Position.class);
        if (pos != null) {
            positionDao.delete(pos);
        }
    }

    public void changePosDetails(PositionDTO positionDTO) {

    }

    public void changeStatusForPosition(int positionId) {
    }

     public boolean obtainPosExist(String posName){
        return positionDao.loadPosExist(posName);
    }
}
