
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.Http;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;


namespace WebApplication.API
{
    public class Startup
    {
        public void ConfigureServices(IServiceCollection services)//adds needed services
        {
            services.AddControllers();
            services.AddSwaggerDocument();
           // For more information on how to configure your application, visit https://go.microsoft.com/fwlink/?LinkID=398940
        }
        //this method configure the HTTP request pipeline
        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }
            app.UseRouting();
            app.UseOpenApi();
            app.UseSwaggerUi3();
            app.UseEndpoints(endPoints =>
            {
                endPoints.MapControllers();
        });
        }
    }
}
