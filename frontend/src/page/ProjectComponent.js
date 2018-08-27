import React,{Component} from 'react';
import {Table, Divider, Tag} from 'antd';

const columns = [{
    title: 'Name',
    dataIndex: 'firstName',
    key: 'firstName',
    render: (text,row)=><a>{text+row.lastName}</a>
},{
    title: 'DOB',
    dataIndex: 'dob',
    key: 'dob',
},{
    title: 'DOJ',
    dataIndex: 'doj',
    key: 'doj',
},{
    title: 'Salary',
    dataIndex: 'salary',
    key: 'salary',
},{
    title: 'Active',
    dataIndex: 'active',
    key: 'active',
},{
    title: 'Designation',
    dataIndex: 'designation',
    key: 'designation',
},{
    title: 'Action',
    key: 'action',
    render: (text,record) =>(
        <span>
            <a>Edit</a>
            <Divider type="vertical" />
            <a>Delete</a>
        </span>
    ),
}];



class ProjectComponent extends Component{
    render(){
        return(
            <Table columns={columns} dataSource={} />
        );
    }
}