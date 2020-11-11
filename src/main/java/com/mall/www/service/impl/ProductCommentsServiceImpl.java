package com.mall.www.service.impl;

import com.mall.www.common.StatusCode;
import com.mall.www.common.dto.ProductCommentsDto;
import com.mall.www.common.vo.ProductCommentsVo;
import com.mall.www.entity.ProductComments;
import com.mall.www.exception.ServiceException;
import com.mall.www.mapper.ProductCommentsMapper;
import com.mall.www.service.ProductCommentsService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCommentsServiceImpl implements ProductCommentsService {

    @Resource
    ProductCommentsMapper mapper;

    @Override
    public List<ProductCommentsVo> selectProductCommentsByPro(Long pid) {
        List<ProductComments> pro=null;
        List<ProductCommentsVo> list=null;
        try {
            pro = mapper.selectProductCommentsByPro(pid);
            BeanUtils.copyProperties(pro,list);
        }catch (Exception e){
            throw new ServiceException(StatusCode.SERVER_ERROR);
        }finally {
            return list;
        }
    }

    @Override
    public List<ProductCommentsVo> selectProductCommentsByUid(Integer uid) {
        List<ProductComments> pro=null;
        List<ProductCommentsVo> list=new ArrayList<>();
        try {
            pro = mapper.selectProductCommentsByUid(uid);
            BeanUtils.copyProperties(pro,list);
        }catch (Exception e){
            throw new ServiceException(StatusCode.SERVER_ERROR);
        }finally {
            return list;
        }
    }

    @Override
    public Integer insertProductComments(ProductCommentsDto productCommentsDto) {
        Integer integer =null;
        ProductComments productComments = new ProductComments();
        try {
            BeanUtils.copyProperties(productCommentsDto,productComments);
            mapper.insertProductComments(productComments);
        }catch (Exception e){
            throw new ServiceException(StatusCode.SERVER_ERROR);
        }finally {
            return integer;
        }
    }

    @Override
    public Integer updateAnswer(Integer mid, String answer) {
        Integer integer = null;
        try {
            mapper.updateAnswer(mid, answer);
        }catch (Exception e){
            throw new ServiceException(StatusCode.SERVER_ERROR);
        }finally {
            return integer;
        }
    }
}