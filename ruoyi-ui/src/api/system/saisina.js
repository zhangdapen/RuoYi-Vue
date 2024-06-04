
import request from '@/utils/request'
// 新增飞机数据
export function addPlaneData(data) {
  return request({
    url: '/create',
    method: 'post',
    data: data
  })
}
// 查询飞机数据
export function listPlaneData(query) {
  return request({
    url: '/list',
    method: 'get',
    params: query
  })
}

// 删除飞机数据
export function deletePlaneData(query) {
  return request({
    url: '/delete',
    method: 'get',
    params: query
  })
}

// 获取单条飞机数据
export function getPlanePost(query) {
  return request({
    url: '/data',
    method: 'get',
    params: query
  })
}

// 更新数据
export function updatePlaneData(data) {
  return request({
    url: '/update',
    method: 'post',
    data: data
  })
}

