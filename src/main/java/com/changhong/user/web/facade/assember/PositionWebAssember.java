package com.changhong.user.web.facade.assember;

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

    public static Position toPosDomain(){
        Position position=null;



        return position;
    }


    public static PositionDTO toPosDTO(Position position){
        PositionDTO positionDTO=null;

        return positionDTO;
    }

    public static List<PositionDTO> toPosDTOList(List<Position> posDomain){
        List<PositionDTO> posDTO = new ArrayList<PositionDTO>();


        return posDTO;
    }
}
