package com.changhong.user.web.facade.assember;

import com.changhong.common.repository.EntityLoadHolder;
import com.changhong.user.domain.Position;
import com.changhong.user.web.facade.dto.PositionDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: lenovo
 * Date: 16-3-7
 * Time: 下午5:17
 * To change this template use File | Settings | File Templates.
 */
public class PositionWebAssember {

    public static Position toPosDomain(PositionDTO positionDTO) {
        Position position = null;
        if (positionDTO.getId() > 0) {
            position = (Position) EntityLoadHolder.getUserDao().findById(positionDTO.getId(), Position.class);
            position.setName(positionDTO.getName());
            position.setDes(positionDTO.getDes());
        } else {
            position = new Position(positionDTO.getName(), positionDTO.getDes());
        }


        return position;
    }


    public static PositionDTO toPosDTO(Position position) {
        PositionDTO positionDTO = new PositionDTO();
        if (position != null) {
            positionDTO.setName(position.getName());
            positionDTO.setDes(position.getDes());
            positionDTO.setId(position.getId());
        }
        return positionDTO;
    }

    public static List<PositionDTO> toPosDTOList(List<Position> posDomainList) {
        List<PositionDTO> posDTOList = new ArrayList<PositionDTO>();
        if (posDomainList != null) {
            for (Position pos : posDomainList) {
                PositionDTO posDTO = toPosDTO(pos);
                posDTOList.add(posDTO);
            }
        }
        return posDTOList;
    }
}
