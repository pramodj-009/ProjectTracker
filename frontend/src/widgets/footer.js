import React,{Component} from 'react';
import {Layout} from 'antd';
import styled from 'styled-components';

class Footer extends Component {
    

    render(){
        return(
            <Layout.Footer style={{textAlign: 'center'}}>
                Project Tracker ©2018 Created with React-SpringRestAPI-Hibernate
            </Layout.Footer>
        );
    }
}

export default Footer;