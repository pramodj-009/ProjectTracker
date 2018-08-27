import React,{Component} from 'react';
import {Menu, Icon, Layout} from 'antd';
import styled from 'styled-components';

const StyledHeader = styled(Layout.Header)`
    background: linear-gradient(150deg, #00b0d4 0, #0068a9 100%);
`;

const StyledLogo = styled.div`
    width: auto;
    height: 30px
    background: rgba(255,255,255,0);
    color: rgba(255,255,255,1);
    font-size: 20px;
    line-height: 0px;
    margin: 16px 10px;
    padding: 0px;
    float: left;
`;

class Header extends Component{
    render(){
        return (
            <StyledHeader>
                <StyledLogo><p>Project Tracker</p></StyledLogo>
                <Menu mode="horizontal"
                        theme="dark"
                        style={{lineHeight: '50px'}}>
                    <Menu.SubMenu key="sub1" title="Project">
                        <Menu.Item key="1">List</Menu.Item>
                    </Menu.SubMenu>
                    <Menu.SubMenu key="sub2" title="Employee">
                        <Menu.Item key="11">List</Menu.Item>
                    </Menu.SubMenu>
                    <Menu.SubMenu key="sub3" title="Skill">
                        <Menu.Item key="21">List</Menu.Item>
                    </Menu.SubMenu>
                </Menu>
            </StyledHeader>
        );
    }
}

export default Header;