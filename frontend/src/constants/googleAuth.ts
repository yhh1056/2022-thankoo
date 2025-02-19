const GOOGLE_URL = 'https://accounts.google.com/o/oauth2/v2/auth';
const CLIENT_ID =
  process.env.NODE_ENV === 'development'
    ? 'client_id=119823899527-vi7230j5vt9lf8s4aiapcao4pf4n9d98.apps.googleusercontent.com'
    : 'client_id=135992368964-20ad4ul4e3mmia6iok3r9dpg6bshp4uq.apps.googleusercontent.com';
const REDIRECT_URL =
  process.env.NODE_ENV === 'development'
    ? 'redirect_uri=http://localhost:3000/sign-in'
    : 'redirect_uri=https://thankoo.co.kr/sign-in';
const RESPONSE_TYPE = 'response_type=code';
const SCOPE =
  'scope=https://www.googleapis.com/auth/userinfo.email https://www.googleapis.com/auth/userinfo.profile openid';
export const GOOGLE_AUTH_URL = `${GOOGLE_URL}?${CLIENT_ID}&${REDIRECT_URL}&${RESPONSE_TYPE}&${SCOPE}`;
