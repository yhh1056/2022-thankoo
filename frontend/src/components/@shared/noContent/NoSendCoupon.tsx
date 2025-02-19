import styled from '@emotion/styled';
import { Link } from 'react-router-dom';
import { ROUTE_PATH } from '../../../constants/routes';
import { flexCenter } from '../../../styles/mixIn';
import IconEmptyList from '../LogoEmptyList';

const NoSendCoupon = () => {
  return (
    <S.Container>
      <S.Box>
        <IconEmptyList />
        <S.Comment>
          보낸 쿠폰이 없어요😥
          <br />
          원하는 상대에게 쿠폰을 선물해보세요!
        </S.Comment>
        <Link to={`${ROUTE_PATH.SELECT_RECEIVER}`}>
          <S.Button>선물하기💛</S.Button>
        </Link>
      </S.Box>
    </S.Container>
  );
};

const S = {
  Container: styled.div`
    position: absolute;
    left: 50%;
    top: 50%;
    transform: translate(-50%, -50%);
  `,
  Box: styled.div`
    ${flexCenter}
    flex-direction: column;
    width: 280px;
    height: fit-content;
    background-color: #1d1d1d;
    border-radius: 10px;
    color: ${({ theme }) => theme.header.color};
    text-align: center;
    gap: 8px;
    padding: 30px 10px;
  `,
  Comment: styled.h3`
    line-height: 30px;
  `,
  Button: styled.button`
    background-color: ${({ theme }) => theme.primary};
    color: ${({ theme }) => theme.button.abled};
    padding: 8px 12px;
    border: none;
    border-radius: 6px;
    margin-top: 20px;
  `,
};
export default NoSendCoupon;
