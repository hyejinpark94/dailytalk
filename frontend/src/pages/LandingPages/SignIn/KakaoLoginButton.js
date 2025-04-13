import React from 'react';
import Button from '@mui/material/Button';
import { styled } from '@mui/material/styles';
import KakaoIcon from './kakao-icon.png'; // 카카오 로고 이미지 (Kakao Developers에서 다운로드)

const KakaoButton = styled(Button)({
  backgroundColor: '#FEE500',
  color: '#000000',
  fontWeight: 'bold',
  fontSize: '16px',
  textTransform: 'none',
  padding: '10px 20px',
  borderRadius: '12px',
  //display: 'flex',
  alignItems: 'center',
  justifyContent: 'center',
  '&:hover': {
    backgroundColor: '#FFD700', // hover 시 색상
  },
});

const KakaoLoginButton = () => {
  const handleLogin = () => {
    const REST_API_KEY = process.env.REACT_APP_KAKAO_REST_API_KEY; // .env 파일에 저장된 API 키
    const REDIRECT_URI = 'http://localhost:8080/login/oauth2/code/kakao'; // 리다이렉트 URI
    const KAKAO_AUTH_URL = `https://kauth.kakao.com/oauth/authorize?client_id=${REST_API_KEY}&redirect_uri=${REDIRECT_URI}&response_type=code`;

    window.location.href = KAKAO_AUTH_URL; // 카카오 인증 URL로 이동
  };

  return (
    <KakaoButton onClick={handleLogin}>
      <img src={KakaoIcon} alt="Kakao Icon" />
    </KakaoButton>
  );
};

export default KakaoLoginButton;
