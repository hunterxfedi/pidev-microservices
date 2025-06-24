# Step 1: Build the Angular app
FROM node:18-alpine as build

WORKDIR /app
COPY package*.json ./
RUN npm install

COPY . .
RUN npm run build --prod

# Step 2: Serve with NGINX
FROM nginx:alpine

COPY --from=build /app/dist/stage-ing-app /usr/share/nginx/html

# Optional: Use custom nginx config for SPA routing
COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]
